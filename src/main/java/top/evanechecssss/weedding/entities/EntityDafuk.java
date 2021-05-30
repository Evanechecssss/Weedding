package top.evanechecssss.weedding.entities;


import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import top.evanechecssss.weedding.api.WeeddingMisc;
import top.evanechecssss.weedding.init.WeeddingItems;
import top.evanechecssss.weedding.utils.AchievementHelper;

import java.util.Set;

public class EntityDafuk extends EntitySheep {
    private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(Items.CARROT, Items.POTATO, Items.BEETROOT, WeeddingItems.HEMP_FOOD);
    public static final DataParameter<Boolean> IS_CHEST = EntityDataManager.createKey(EntityDafuk.class, DataSerializers.BOOLEAN);
    public EntityDafuk(World worldIn) {
        super(worldIn);
    }


    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(35);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
    }

    public Boolean isChest() {
        return this.dataManager.get(IS_CHEST);
    }

    public void setIsChest(boolean isChest) {
        this.dataManager.set(IS_CHEST, isChest);
    }

    @Override
    public EnumActionResult applyPlayerInteraction(EntityPlayer player, Vec3d vec, EnumHand hand) {
        ItemStack itemHand = player.getHeldItem(hand);
        AchievementHelper.completeAchievement(player, "hookah", "dafuk");
        if (itemHand.getItem().equals(Item.getItemFromBlock(Blocks.WHITE_SHULKER_BOX))) {
            AchievementHelper.completeAchievement(player, "hookah", "dafuk_shulker");
            itemHand.setCount(0);
            if (isChild()) {
                AchievementHelper.completeAchievement(player, "hookah", "dafuk_loader");
            }
            this.setIsChest(true);
            return EnumActionResult.SUCCESS;

        }

        return EnumActionResult.PASS;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();

        this.tasks.taskEntries.clear();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
        this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(4, new EntityAITempt(this, 1.2D, Items.CARROT_ON_A_STICK, false));
        this.tasks.addTask(4, new EntityAITempt(this, 1.2D, false, TEMPTATION_ITEMS));
        this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }

    @Override
    public float getEyeHeight() {
        return 1;
    }

    @Override
    public boolean hasNoGravity() {
        return false;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void entityInit() {
        this.dataManager.register(IS_CHEST, Boolean.FALSE);
        super.entityInit();
    }

    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return WeeddingMisc.LootTable.DAFUK_LOOT;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SHEEP_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_SHEEP_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SHEEP_DEATH;
    }

    @Override
    public EntityDafuk createChild(EntityAgeable ageable) {
        return new EntityDafuk(this.world);
    }


    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound);
        compound.setBoolean("Chest", this.isChest());
        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("Chest")) {
            this.setIsChest(compound.getBoolean("Chest"));
        }
    }


}

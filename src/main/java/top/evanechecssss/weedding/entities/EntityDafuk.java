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
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import top.evanechecssss.weedding.init.WeeddingItems;

import java.util.Set;

public class EntityDafuk extends EntitySheep {
    private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(Items.CARROT, Items.POTATO, Items.BEETROOT, WeeddingItems.HEMP_FOOD);
    public EntityDafuk(World worldIn) {
        super(worldIn);
    }

    private boolean IsChest = false;

    public boolean isChest() {
        return IsChest;
    }


    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(35);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
    }

    @Override
    public EnumActionResult applyPlayerInteraction(EntityPlayer player, Vec3d vec, EnumHand hand) {
        ItemStack itemHand = player.getHeldItem(hand);
        if (itemHand.getItem().equals(Item.getItemFromBlock(Blocks.WHITE_SHULKER_BOX))) {
            itemHand.setCount(0);
            IsChest = true;
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }

    @Override
    protected void initEntityAI() {
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
        return 2;
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
}

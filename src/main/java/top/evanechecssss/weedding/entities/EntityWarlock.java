package top.evanechecssss.weedding.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import top.evanechecssss.weedding.init.WeeddingItems;

public class EntityWarlock extends EntityMob {
    public EntityWarlock(World worldIn) {
        super(worldIn);
        this.setSize(3, 5);
    }

    public void onUpdate() {
        super.onUpdate();

        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
    }

    @Override
    protected void entityInit() {
        super.entityInit();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
    }


    @Override
    protected void initEntityAI() {

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
    public SoundCategory getSoundCategory() {
        return SoundCategory.AMBIENT;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(WeeddingItems.HEMP_AXE));
    }

}

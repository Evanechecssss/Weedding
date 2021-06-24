package top.evanechecssss.weedding.common.items.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.Nullable;
import top.evanechecssss.weedding.common.entities.models.ExoskeletonModel;
import top.evanechecssss.weedding.init.WeeddingCreativeTabs;
import top.evanechecssss.weedding.init.WeeddingInfo;
import top.evanechecssss.weedding.init.WeeddingItems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExoskeletonArmor extends ItemArmor {
    public static final Map<Item, ModelBiped> ARMOR_MODELS = new HashMap<>();
    private boolean hasEnergy = false;
    public ExoskeletonArmor(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.setRegistryName(name);
        this.setUnlocalizedName(WeeddingInfo.MODID + "." + name);
        this.setMaxStackSize(1);
        this.setCreativeTab(WeeddingCreativeTabs.WEEDDING_CT);

    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped model) {
        ExoskeletonModel HeadModel = new ExoskeletonModel(0);
        ExoskeletonModel ArmorModel = new ExoskeletonModel(1);
        ExoskeletonModel LeggsModel = new ExoskeletonModel(2);
        ARMOR_MODELS.put(WeeddingItems.EXOSKELETON_HEAD, HeadModel);
        ARMOR_MODELS.put(WeeddingItems.EXOSKELETON_CHESTPLATE, ArmorModel);
        ARMOR_MODELS.put(WeeddingItems.EXOSKELETON_LEGGS, LeggsModel);
        final ModelBiped armorModel = ARMOR_MODELS.get(this);
        armorModel.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
        armorModel.bipedHeadwear.showModel = true;
        armorModel.bipedBody.showModel = armorSlot == EntityEquipmentSlot.CHEST || armorSlot == EntityEquipmentSlot.LEGS;
        armorModel.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
        armorModel.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
        armorModel.bipedRightLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET;
        armorModel.bipedLeftLeg.showModel = armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET;
        armorModel.isSneak = entityLiving.isSneaking();
        armorModel.isRiding = entityLiving.isRiding();
        armorModel.isChild = entityLiving.isChild();
        return armorModel;
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return "weedding:textures/entity/exoskeleton.png";
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!hasEnergy) return;
        if (!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
        NBTTagCompound nbt = stack.getTagCompound();
        if (!nbt.hasKey("energy")) nbt.setInteger("energy", 500);
        stack.setTagCompound(nbt);

    }

    public ExoskeletonArmor setHasEnergy() {
        this.hasEnergy = true;
        return this;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (!stack.hasTagCompound()) return;
        NBTTagCompound nbt = stack.getTagCompound();
        if (!nbt.hasKey("energy")) return;
        tooltip.add(TextFormatting.GREEN + I18n.format("weedding.tooltip.exo", nbt.getInteger("energy")));
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return EnumActionResult.SUCCESS;
    }
}

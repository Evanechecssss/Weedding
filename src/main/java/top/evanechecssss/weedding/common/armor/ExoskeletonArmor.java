package top.evanechecssss.weedding.common.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.Nullable;
import top.evanechecssss.weedding.entities.models.ExoskeletonModel;
import top.evanechecssss.weedding.init.WeeddingItems;
import top.evanechecssss.weedding.utils.reference.WeeddingCreativeTabs;
import top.evanechecssss.weedding.utils.reference.WeeddingInfo;

import java.util.HashMap;
import java.util.Map;

public class ExoskeletonArmor extends ItemArmor {
    public static final Map<Item, ModelBiped> ARMOR_MODELS = new HashMap<>();

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
        armorModel.bipedHeadwear.showModel = false;
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
}

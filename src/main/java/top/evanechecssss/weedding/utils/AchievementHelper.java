package top.evanechecssss.weedding.utils;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import top.evanechecssss.weedding.utils.reference.WeeddingInfo;


public class AchievementHelper {
    public static void completeAchievement(EntityPlayer player, String category, String achievementName) {
        if (!checkPlayerSide(player)) return;
        ResourceLocation location = new ResourceLocation(WeeddingInfo.MODID, category + "/" + achievementName);
        complete(((EntityPlayerMP) player), location);
    }

    public static void completeAchievement(EntityPlayer player, ResourceLocation achievementLocation) {
        if (!checkPlayerSide(player)) return;
        complete((EntityPlayerMP) player, achievementLocation);
    }

    private static boolean checkPlayerSide(EntityPlayer player) {
        return player instanceof EntityPlayerMP;
    }

    private static void complete(EntityPlayerMP player, ResourceLocation location) {

        Advancement _adv = player.mcServer.getAdvancementManager().getAdvancement(location);
        assert _adv != null;
        AdvancementProgress _ap = player.getAdvancements().getProgress(_adv);
        if (!_ap.isDone()) {
            for (String _criterion : _ap.getRemaningCriteria()) {
                player.getAdvancements().grantCriterion(_adv, _criterion);
            }
        }
    }
}

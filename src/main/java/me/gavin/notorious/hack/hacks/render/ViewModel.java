package me.gavin.notorious.hack.hacks.render;

import me.gavin.notorious.event.events.PlayerLivingUpdateEvent;
import me.gavin.notorious.hack.Hack;
import me.gavin.notorious.hack.RegisterHack;
import me.gavin.notorious.hack.RegisterSetting;
import me.gavin.notorious.setting.ModeSetting;
import me.gavin.notorious.setting.NumSetting;
import me.gavin.notorious.util.Timer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import java.awt.*;

@RegisterHack(name = "ViewModel", description = "ez", category = Hack.Category.Render)
public class ViewModel extends Hack {

    @RegisterSetting
    public final NumSetting translateX = new NumSetting("TranslateX", 0, -200, 200, 1);
    @RegisterSetting
    public final NumSetting translateY = new NumSetting("TranslateY", 0, -200, 200, 1);
    @RegisterSetting
    public final NumSetting translateZ = new NumSetting("TranslateZ", 0, -200, 200, 1);

    @RegisterSetting
    public final NumSetting rotateX = new NumSetting("RotateX", 0, -200, 200, 1);
    @RegisterSetting
    public final NumSetting rotateY = new NumSetting("RotateY", 0, -200, 200, 1);
    @RegisterSetting
    public final NumSetting rotateZ = new NumSetting("RotateZ", 0, -200, 200, 1);

    @RegisterSetting
    public final NumSetting scaleX = new NumSetting("ScaleX", 100, 0, 200, 1);
    @RegisterSetting
    public final NumSetting scaleY = new NumSetting("ScaleY", 100, 0, 200, 1);
    @RegisterSetting
    public final NumSetting scaleZ = new NumSetting("ScaleZ", 100, 0, 200, 1);

    public static ViewModel INSTANCE;

    {
        INSTANCE = this;
    }
}

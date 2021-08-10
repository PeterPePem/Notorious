package me.gavin.notorious.hack;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.gavin.notorious.Notorious;
import me.gavin.notorious.gui.api.Bindable;
import me.gavin.notorious.gui.api.Toggleable;
import me.gavin.notorious.hack.hacks.chat.ChatModifications;
import me.gavin.notorious.setting.Setting;
import me.gavin.notorious.stuff.IMinecraft;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;

/**
 * @author Gav06
 * @since 6/15/2021
 */

public abstract class Hack implements Toggleable, Bindable, IMinecraft {
    protected final Notorious notorious = Notorious.INSTANCE;

    private String name;
    private String description;
    private Category category;

    public long lastEnabledTime = -1L;
    public long lastDisabledTime = -1L;

    private int keybind;

    private boolean enabled;

    private final ArrayList<Setting> settings = new ArrayList<>();

    public ArrayList<Setting> getSettings() {
        return settings;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void toggle() {
        if (enabled) disable(); else enable();
    }

    public void enable() {
        enabled = true;
        MinecraftForge.EVENT_BUS.register(this);
        notorious.messageManager.sendToggleMessage(this, true);
        onEnable();
        lastEnabledTime = System.currentTimeMillis();
    }

    public void disable() {
        enabled = false;
        MinecraftForge.EVENT_BUS.unregister(this);
        notorious.messageManager.sendToggleMessage(this, false);
        onDisable();
        lastDisabledTime = System.currentTimeMillis();
    }

    protected void onEnable() { }

    protected void onDisable() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public int getBind() {
        return keybind;
    }

    @Override
    public void setBind(int keybind) {
        this.keybind = keybind;
    }

    public String getMetaData() {
        return "";
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public enum Category {
        Combat,
        Player,
        Movement,
        Render,
        Misc,
        World,
        Chat,
        Client
    }
}
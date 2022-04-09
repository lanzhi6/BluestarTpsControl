package me.lanzhi.bluestartpscontrol;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Method;

public final class BluestarTpsControl extends JavaPlugin
{
    public static Class<?> minecraftServerClass;
    public static Method setmspt;
    @Override
    public void onEnable()
    {
        System.out.println("BluestarTpsControl已启用");
        try
        {
            minecraftServerClass=Class.forName("net.minecraft.server.MinecraftServer");
            setmspt=minecraftServerClass.getMethod("setmspt",long.class);
        }
        catch (Throwable e)
        {
            Bukkit.getLogger().warning("[BluestarTpsControl]错误!未找到类或方法,请反馈此bug谢谢");
        }
        getCommand("settps").setExecutor(new maincommand());
    }

    @Override
    public void onDisable()
    {
        System.out.println("BluestarTpsControl已禁用");
    }
}
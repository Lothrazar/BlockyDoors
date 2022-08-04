package com.lothrazar.blockydoors;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRegistry {

  private static CreativeModeTab TAB = new CreativeModeTab(ModMain.MODID) {

    @Override
    public ItemStack makeIcon() {
      return new ItemStack(DOOR_STONE);
    }
  };
  public static BlockyDoor DOOR_STONE;
  public static BlockyDoor DOOR_COBBLESTONE;
  public static BlockyDoor DOOR_MOSSY_COBBLESTONE;
  public static BlockyDoor DOOR_STONE_BRICKS;
  public static BlockyDoor DOOR_BLACKSTONE;
  public static BlockyDoor DOOR_GRANITE;
  public static BlockyDoor DOOR_ANDESITE;
  public static BlockyDoor DOOR_DIORITE;
  public static BlockyDoor DOOR_BRICKS;
  public static BlockyDoor DOOR_PRISMARINE;
  public static BlockyDoor DOOR_NETHER_BRICKS;
  public static BlockyDoor DOOR_PURPUR;
  public static BlockyDoor DOOR_SANDSTONE;
  public static BlockyDoor DOOR_RED_SANDSTONE;
  public static BlockyDoor DOOR_QUARTZ;
  public static BlockyDoor DOOR_RED_MUSHROOM;
  public static BlockyDoor DOOR_BROWN_MUSHROOM;
  public static BlockyDoor DOOR_SMOOTH_STONE;
  public static BlockyDoor DOOR_NETHERRACK;
  public static BlockyDoor DOOR_END_STONE;
  public static BlockyDoor DOOR_OBSIDIAN;
  public static BlockyDoor DOOR_MOSSY_STONE_BRICKS;
  public static BlockyDoor DOOR_CRACKED_STONE_BRICKS;
  public static BlockyDoor DOOR_END_STONE_BRICKS;
  public static BlockyDoor DOOR_POLISHED_BLACKSTONE_BRICKS;
  public static BlockyDoor DOOR_RED_NETHER_BRICKS;
  public static BlockyDoor DOOR_PRISMARINE_BRICKS;
  public static BlockyDoor DOOR_DARK_PRISMARINE;

  @SubscribeEvent
  public static void onBlocksRegistry(RegisterEvent event) {
    event.register(Registry.BLOCK_REGISTRY, r -> {
      r.register("door_stone", createDoor("", Blocks.STONE, Properties.of(Material.STONE)));
      r.register("door_smooth_stone", createDoor("", Blocks.STONE, Properties.of(Material.STONE)));
      r.register("door_cobblestone", createDoor("", Blocks.COBBLESTONE, Properties.of(Material.STONE)));
      r.register("door_mossy_cobblestone", createDoor("", Blocks.MOSSY_COBBLESTONE, Properties.of(Material.STONE)));
      r.register("door_stone_bricks", createDoor("", Blocks.STONE_BRICKS, Properties.of(Material.STONE)));
      r.register("door_blackstone", createDoor("", Blocks.BLACKSTONE, Properties.of(Material.STONE)));
      r.register("door_polished_blackstone_bricks", createDoor("", Blocks.POLISHED_BLACKSTONE_BRICKS, Properties.of(Material.STONE)));
      r.register("door_granite", createDoor("", Blocks.GRANITE, Properties.of(Material.STONE)));
      r.register("door_andesite", createDoor("", Blocks.ANDESITE, Properties.of(Material.STONE)));
      r.register("door_diorite", createDoor("", Blocks.DIORITE, Properties.of(Material.STONE)));
      r.register("door_bricks", createDoor("", Blocks.BRICKS, Properties.of(Material.STONE)));
      r.register("door_prismarine", createDoor("", Blocks.PRISMARINE, Properties.of(Material.STONE)));
      r.register("door_prismarine_bricks", createDoor("", Blocks.PRISMARINE_BRICKS, Properties.of(Material.STONE)));
      r.register("door_dark_prismarine", createDoor("", Blocks.DARK_PRISMARINE, Properties.of(Material.STONE)));
      r.register("door_netherrack", createDoor("", Blocks.NETHERRACK, Properties.of(Material.STONE)));
      r.register("door_nether_bricks", createDoor("", Blocks.NETHER_BRICKS, Properties.of(Material.STONE)));
      r.register("door_red_nether_bricks", createDoor("", Blocks.RED_NETHER_BRICKS, Properties.of(Material.STONE)));
      r.register("door_purpur", createDoor("", Blocks.PURPUR_BLOCK, Properties.of(Material.STONE)));
      r.register("door_sandstone", createDoor("", Blocks.SANDSTONE, Properties.of(Material.STONE)));
      r.register("door_red_sandstone", createDoor("", Blocks.RED_SANDSTONE, Properties.of(Material.STONE)));
      r.register("door_quartz", createDoor("", Blocks.QUARTZ_BLOCK, Properties.of(Material.STONE)));
      r.register("door_red_mushroom", createDoor("", Blocks.RED_MUSHROOM_BLOCK, Properties.of(Material.STONE)));
      r.register("door_brown_mushroom", createDoor("", Blocks.BROWN_MUSHROOM_BLOCK, Properties.of(Material.STONE)));
      r.register("door_end_stone", createDoor("", Blocks.END_STONE, Properties.of(Material.STONE)));
      r.register("door_end_stone_bricks", createDoor("", Blocks.END_STONE_BRICKS, Properties.of(Material.STONE)));
      r.register("door_obsidian", createDoor("", Blocks.OBSIDIAN, Properties.of(Material.STONE)));
      r.register("door_mossy_stone_bricks", createDoor("", Blocks.MOSSY_STONE_BRICKS, Properties.of(Material.STONE)));
      r.register("door_cracked_stone_bricks", createDoor("", Blocks.CRACKED_STONE_BRICKS, Properties.of(Material.STONE)));
    });
    event.register(Registry.ITEM_REGISTRY, r -> {
      for (BlockyDoor b : BLOCKLIST) {
        String id = b.getDescriptionId().replace(HAX, "");
        r.register(id, createItem(b));
      }
    });
  }

  private static final String HAX = "block." + ModMain.MODID + ".";

  private static Item createItem(BlockyDoor door) {
    return new BlockItem(door, new Item.Properties().tab(TAB));
  }

  private static final List<BlockyDoor> BLOCKLIST = new ArrayList<>();

  public static BlockyDoor createDoor(String name, Block block, Block.Properties p) {
    BlockyDoor b = new BlockyDoor(wrap(p, block), name);
    BLOCKLIST.add(b);
    return b;
  }

  @SuppressWarnings("deprecation")
  private static Block.Properties wrap(Block.Properties propIn, Block blockIn) {
    if (blockIn.properties != null
        && blockIn.properties.materialColor != null) {
      propIn.materialColor = (state) -> {
        return blockIn.properties.materialColor.apply(blockIn.defaultBlockState());
      };
    }
    return propIn.sound(blockIn.getSoundType(blockIn.defaultBlockState()))
        .strength(blockIn.defaultBlockState().destroySpeed);
  }
}

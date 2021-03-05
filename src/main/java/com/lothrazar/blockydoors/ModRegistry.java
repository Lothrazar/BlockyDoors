package com.lothrazar.blockydoors;

import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRegistry {

  private static ItemGroup TAB = new ItemGroup(ModMain.MODID) {

    @Override
    public ItemStack createIcon() {
      return new ItemStack(DOOR_STONE);
    }
  };
  @ObjectHolder(ModMain.MODID + ":door_stone")
  public static BlockyDoor DOOR_STONE;
  @ObjectHolder(ModMain.MODID + ":door_cobblestone")
  public static BlockyDoor DOOR_COBBLESTONE;
  @ObjectHolder(ModMain.MODID + ":door_mossy_cobblestone")
  public static BlockyDoor DOOR_MOSSY_COBBLESTONE;
  @ObjectHolder(ModMain.MODID + ":door_stone_bricks")
  public static BlockyDoor DOOR_STONE_BRICKS;
  @ObjectHolder(ModMain.MODID + ":door_blackstone")
  public static BlockyDoor DOOR_BLACKSTONE;
  @ObjectHolder(ModMain.MODID + ":door_granite")
  public static BlockyDoor DOOR_GRANITE;
  @ObjectHolder(ModMain.MODID + ":door_andesite")
  public static BlockyDoor DOOR_ANDESITE;
  @ObjectHolder(ModMain.MODID + ":door_diorite")
  public static BlockyDoor DOOR_DIORITE;
  @ObjectHolder(ModMain.MODID + ":door_bricks")
  public static BlockyDoor DOOR_BRICKS;
  @ObjectHolder(ModMain.MODID + ":door_prismarine")
  public static BlockyDoor DOOR_PRISMARINE;
  @ObjectHolder(ModMain.MODID + ":door_nether_bricks")
  public static BlockyDoor DOOR_NETHER_BRICKS;
  @ObjectHolder(ModMain.MODID + ":door_purpur")
  public static BlockyDoor DOOR_PURPUR;
  @ObjectHolder(ModMain.MODID + ":door_sandstone")
  public static BlockyDoor DOOR_SANDSTONE;
  @ObjectHolder(ModMain.MODID + ":door_red_sandstone")
  public static BlockyDoor DOOR_RED_SANDSTONE;
  @ObjectHolder(ModMain.MODID + ":door_quartz")
  public static BlockyDoor DOOR_QUARTZ;
  @ObjectHolder(ModMain.MODID + ":door_red_mushroom")
  public static BlockyDoor DOOR_RED_MUSHROOM;
  @ObjectHolder(ModMain.MODID + ":door_brown_mushroom")
  public static BlockyDoor DOOR_BROWN_MUSHROOM;
  @ObjectHolder(ModMain.MODID + ":door_smooth_stone")
  public static BlockyDoor DOOR_SMOOTH_STONE;
  @ObjectHolder(ModMain.MODID + ":door_netherrack")
  public static BlockyDoor DOOR_NETHERRACK;
  @ObjectHolder(ModMain.MODID + ":door_end_stone")
  public static BlockyDoor DOOR_END_STONE;
  @ObjectHolder(ModMain.MODID + ":door_obsidian")
  public static BlockyDoor DOOR_OBSIDIAN;
  @ObjectHolder(ModMain.MODID + ":door_mossy_stone_bricks")
  public static BlockyDoor DOOR_MOSSY_STONE_BRICKS;
  @ObjectHolder(ModMain.MODID + ":door_cracked_stone_bricks")
  public static BlockyDoor DOOR_CRACKED_STONE_BRICKS;
  @ObjectHolder(ModMain.MODID + ":door_end_stone_bricks")
  public static BlockyDoor DOOR_END_STONE_BRICKS;
  @ObjectHolder(ModMain.MODID + ":door_polished_blackstone_bricks")
  public static BlockyDoor DOOR_POLISHED_BLACKSTONE_BRICKS;
  @ObjectHolder(ModMain.MODID + ":door_red_nether_bricks")
  public static BlockyDoor DOOR_RED_NETHER_BRICKS;
  @ObjectHolder(ModMain.MODID + ":door_prismarine_bricks")
  public static BlockyDoor DOOR_PRISMARINE_BRICKS;
  @ObjectHolder(ModMain.MODID + ":door_dark_prismarine")
  public static BlockyDoor DOOR_DARK_PRISMARINE;

  @SubscribeEvent
  public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
    IForgeRegistry<Block> r = event.getRegistry();
    r.register(createDoor("door_stone", Blocks.STONE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_smooth_stone", Blocks.STONE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_cobblestone", Blocks.COBBLESTONE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_mossy_cobblestone", Blocks.MOSSY_COBBLESTONE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_stone_bricks", Blocks.STONE_BRICKS, Properties.create(Material.ROCK)));
    r.register(createDoor("door_blackstone", Blocks.BLACKSTONE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_polished_blackstone_bricks", Blocks.POLISHED_BLACKSTONE_BRICKS, Properties.create(Material.ROCK)));
    r.register(createDoor("door_granite", Blocks.GRANITE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_andesite", Blocks.ANDESITE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_diorite", Blocks.DIORITE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_bricks", Blocks.BRICKS, Properties.create(Material.ROCK)));
    r.register(createDoor("door_prismarine", Blocks.PRISMARINE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_prismarine_bricks", Blocks.PRISMARINE_BRICKS, Properties.create(Material.ROCK)));
    r.register(createDoor("door_dark_prismarine", Blocks.DARK_PRISMARINE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_netherrack", Blocks.NETHERRACK, Properties.create(Material.ROCK)));
    r.register(createDoor("door_nether_bricks", Blocks.NETHER_BRICKS, Properties.create(Material.ROCK)));
    r.register(createDoor("door_red_nether_bricks", Blocks.RED_NETHER_BRICKS, Properties.create(Material.ROCK)));
    r.register(createDoor("door_purpur", Blocks.PURPUR_BLOCK, Properties.create(Material.ROCK)));
    r.register(createDoor("door_sandstone", Blocks.SANDSTONE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_red_sandstone", Blocks.RED_SANDSTONE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_quartz", Blocks.QUARTZ_BLOCK, Properties.create(Material.ROCK)));
    r.register(createDoor("door_red_mushroom", Blocks.RED_MUSHROOM_BLOCK, Properties.create(Material.ROCK)));
    r.register(createDoor("door_brown_mushroom", Blocks.BROWN_MUSHROOM_BLOCK, Properties.create(Material.ROCK)));
    r.register(createDoor("door_end_stone", Blocks.END_STONE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_end_stone_bricks", Blocks.END_STONE_BRICKS, Properties.create(Material.ROCK)));
    r.register(createDoor("door_obsidian", Blocks.OBSIDIAN, Properties.create(Material.ROCK)));
    r.register(createDoor("door_mossy_stone_bricks", Blocks.MOSSY_STONE_BRICKS, Properties.create(Material.ROCK)));
    r.register(createDoor("door_cracked_stone_bricks", Blocks.CRACKED_STONE_BRICKS, Properties.create(Material.ROCK)));
  }

  @SubscribeEvent
  public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
    IForgeRegistry<Item> r = event.getRegistry();
    r.register(createItem(DOOR_STONE));
    r.register(createItem(DOOR_SMOOTH_STONE));
    r.register(createItem(DOOR_COBBLESTONE));
    r.register(createItem(DOOR_MOSSY_COBBLESTONE));
    r.register(createItem(DOOR_STONE_BRICKS));
    r.register(createItem(DOOR_BLACKSTONE));
    r.register(createItem(DOOR_GRANITE));
    r.register(createItem(DOOR_ANDESITE));
    r.register(createItem(DOOR_DIORITE));
    r.register(createItem(DOOR_BRICKS));
    r.register(createItem(DOOR_PRISMARINE));
    r.register(createItem(DOOR_NETHERRACK));
    r.register(createItem(DOOR_NETHER_BRICKS));
    r.register(createItem(DOOR_PURPUR));
    r.register(createItem(DOOR_SANDSTONE));
    r.register(createItem(DOOR_RED_SANDSTONE));
    r.register(createItem(DOOR_QUARTZ));
    r.register(createItem(DOOR_RED_MUSHROOM));
    r.register(createItem(DOOR_BROWN_MUSHROOM));
    r.register(createItem(DOOR_END_STONE));
    r.register(createItem(DOOR_END_STONE_BRICKS));
    r.register(createItem(DOOR_OBSIDIAN));
    r.register(createItem(DOOR_MOSSY_STONE_BRICKS));
    r.register(createItem(DOOR_CRACKED_STONE_BRICKS));
    r.register(createItem(DOOR_RED_NETHER_BRICKS));
    r.register(createItem(DOOR_PRISMARINE_BRICKS));
    r.register(createItem(DOOR_DARK_PRISMARINE));
    r.register(createItem(DOOR_POLISHED_BLACKSTONE_BRICKS));
  }

  private static Item createItem(BlockyDoor door) {
    return new BlockItem(door, new Item.Properties().group(TAB)).setRegistryName(door.rawName());
  }

  public static BlockyDoor createDoor(String name, Block block, Block.Properties p) {
    BlockyDoor b = new BlockyDoor(wrap(p, block), name);
    return b;
  }

  @SuppressWarnings("deprecation")
  private static Block.Properties wrap(Block.Properties propIn, Block blockIn) {
    if (blockIn.properties != null
        && blockIn.properties.blockColors != null) {
      propIn.blockColors = (state) -> {
        return blockIn.properties.blockColors.apply(blockIn.getDefaultState());
      };
    }
    return propIn.sound(blockIn.getSoundType(blockIn.getDefaultState()))
        .hardnessAndResistance(blockIn.getDefaultState().hardness);
  }
}

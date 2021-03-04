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

  private static ItemGroup itemGroup = new ItemGroup(ModMain.MODID) {

    @Override
    public ItemStack createIcon() {
      return new ItemStack(door_stone);
    }
  };
  @ObjectHolder(ModMain.MODID + ":door_stone")
  public static BlockyDoor door_stone;
  @ObjectHolder(ModMain.MODID + ":door_cobblestone")
  public static BlockyDoor door_cobblestone;
  @ObjectHolder(ModMain.MODID + ":door_cobblestone_mossy")
  public static BlockyDoor door_mossy_cobblestone;
  @ObjectHolder(ModMain.MODID + ":door_stonebricks")
  public static BlockyDoor door_stone_bricks;
  @ObjectHolder(ModMain.MODID + ":door_blackstone")
  public static BlockyDoor door_blackstone;
  @ObjectHolder(ModMain.MODID + ":door_granite")
  public static BlockyDoor door_granite;
  @ObjectHolder(ModMain.MODID + ":door_andesite")
  public static BlockyDoor door_andesite;
  @ObjectHolder(ModMain.MODID + ":door_diorite")
  public static BlockyDoor door_diorite;
  @ObjectHolder(ModMain.MODID + ":door_bricks")
  public static BlockyDoor door_bricks;
  @ObjectHolder(ModMain.MODID + ":door_prismarine")
  public static BlockyDoor door_prismarine;
  @ObjectHolder(ModMain.MODID + ":door_netherbrick")
  public static BlockyDoor door_nether_bricks;
  @ObjectHolder(ModMain.MODID + ":door_purpur")
  public static BlockyDoor door_purpur;
  @ObjectHolder(ModMain.MODID + ":door_sandstone")
  public static BlockyDoor door_sandstone;
  @ObjectHolder(ModMain.MODID + ":door_red_sandstone")
  public static BlockyDoor door_red_sandstone;
  @ObjectHolder(ModMain.MODID + ":door_quartz")
  public static BlockyDoor door_quartz;
  @ObjectHolder(ModMain.MODID + ":door_red_mushroom")
  public static BlockyDoor door_red_mushroom;
  @ObjectHolder(ModMain.MODID + ":door_brown_mushroom")
  public static BlockyDoor door_brown_mushroom;
  @ObjectHolder(ModMain.MODID + ":door_smooth_stone")
  public static BlockyDoor door_smooth_stone;
  @ObjectHolder(ModMain.MODID + ":door_netherrack")
  public static BlockyDoor door_netherrack;

  @SubscribeEvent
  public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
    IForgeRegistry<Block> r = event.getRegistry();
    r.register(createDoor("door_stone", Blocks.STONE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_smooth_stone", Blocks.STONE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_cobblestone", Blocks.COBBLESTONE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_mossy_cobblestone", Blocks.MOSSY_COBBLESTONE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_stone_bricks", Blocks.STONE_BRICKS, Properties.create(Material.ROCK)));
    r.register(createDoor("door_blackstone", Blocks.BLACKSTONE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_granite", Blocks.GRANITE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_andesite", Blocks.ANDESITE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_diorite", Blocks.DIORITE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_bricks", Blocks.BRICKS, Properties.create(Material.ROCK)));
    r.register(createDoor("door_prismarine", Blocks.PRISMARINE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_netherrack", Blocks.NETHER_BRICKS, Properties.create(Material.ROCK)));
    r.register(createDoor("door_nether_bricks", Blocks.NETHER_BRICKS, Properties.create(Material.ROCK)));
    r.register(createDoor("door_purpur", Blocks.PURPUR_BLOCK, Properties.create(Material.ROCK)));
    r.register(createDoor("door_sandstone", Blocks.SANDSTONE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_red_sandstone", Blocks.RED_SANDSTONE, Properties.create(Material.ROCK)));
    r.register(createDoor("door_quartz", Blocks.QUARTZ_BLOCK, Properties.create(Material.ROCK)));
    r.register(createDoor("door_red_mushroom", Blocks.RED_MUSHROOM_BLOCK, Properties.create(Material.ROCK)));
    r.register(createDoor("door_brown_mushroom", Blocks.BROWN_MUSHROOM_BLOCK, Properties.create(Material.ROCK)));
  }

  @SubscribeEvent
  public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
    IForgeRegistry<Item> r = event.getRegistry();
    r.register(createItem(door_stone));
    r.register(createItem(door_smooth_stone));
    r.register(createItem(door_cobblestone));
    r.register(createItem(door_mossy_cobblestone));
    r.register(createItem(door_stone_bricks));
    r.register(createItem(door_blackstone));
    r.register(createItem(door_granite));
    r.register(createItem(door_andesite));
    r.register(createItem(door_diorite));
    r.register(createItem(door_bricks));
    r.register(createItem(door_prismarine));
    r.register(createItem(door_netherrack));
    r.register(createItem(door_nether_bricks));
    r.register(createItem(door_purpur));
    r.register(createItem(door_sandstone));
    r.register(createItem(door_red_sandstone));
    r.register(createItem(door_quartz));
    r.register(createItem(door_red_mushroom));
    r.register(createItem(door_brown_mushroom));
  }

  private static Item createItem(BlockyDoor door) {
    return new BlockItem(door, new Item.Properties().group(itemGroup)).setRegistryName(door.rawName());
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

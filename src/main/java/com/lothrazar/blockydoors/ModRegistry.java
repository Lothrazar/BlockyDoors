package com.lothrazar.blockydoors;

import java.util.ArrayList;
import java.util.List;
import com.lothrazar.library.util.BlockUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.RegisterEvent;

@EventBusSubscriber(modid = ModMain.MODID)//, bus = EventBusSubscriber.Bus.MOD !!
public class ModRegistry {

  public static BlockyDoor DOOR_STONE;

  @SubscribeEvent
  public static void onBlocksRegistry(RegisterEvent event) {
    event.register(Registries.BLOCK, r -> {
      DOOR_STONE = createDoor("door_stone", BlockSetType.STONE, Blocks.STONE, Properties.of());
      r.register(rl("door_stone"), DOOR_STONE);
      r.register(rl("door_smooth_stone"), createDoor("door_smooth_stone", BlockSetType.STONE, Blocks.STONE, Properties.of()));
      r.register(rl("door_cobblestone"), createDoor("door_cobblestone", BlockSetType.STONE, Blocks.COBBLESTONE, Properties.of()));
      r.register(rl("door_mossy_cobblestone"), createDoor("door_mossy_cobblestone", BlockSetType.STONE, Blocks.MOSSY_COBBLESTONE, Properties.of()));
      r.register(rl("door_stone_bricks"), createDoor("door_stone_bricks", BlockSetType.STONE, Blocks.STONE_BRICKS, Properties.of()));
      r.register(rl("door_blackstone"), createDoor("door_blackstone", BlockSetType.STONE, Blocks.BLACKSTONE, Properties.of()));
      r.register(rl("door_polished_blackstone_bricks"), createDoor("door_polished_blackstone_bricks", BlockSetType.STONE, Blocks.POLISHED_BLACKSTONE_BRICKS, Properties.of()));
      r.register(rl("door_granite"), createDoor("door_granite", BlockSetType.STONE, Blocks.GRANITE, Properties.of()));
      r.register(rl("door_andesite"), createDoor("door_andesite", BlockSetType.STONE, Blocks.ANDESITE, Properties.of()));
      r.register(rl("door_diorite"), createDoor("door_diorite", BlockSetType.STONE, Blocks.DIORITE, Properties.of()));
      r.register(rl("door_bricks"), createDoor("door_bricks", BlockSetType.STONE, Blocks.BRICKS, Properties.of()));
      r.register(rl("door_prismarine"), createDoor("door_prismarine", BlockSetType.STONE, Blocks.PRISMARINE, Properties.of()));
      r.register(rl("door_prismarine_bricks"), createDoor("door_prismarine_bricks", BlockSetType.STONE, Blocks.PRISMARINE_BRICKS, Properties.of()));
      r.register(rl("door_dark_prismarine"), createDoor("door_dark_prismarine", BlockSetType.STONE, Blocks.DARK_PRISMARINE, Properties.of()));
      r.register(rl("door_netherrack"), createDoor("door_netherrack", BlockSetType.STONE, Blocks.NETHERRACK, Properties.of()));
      r.register(rl("door_nether_bricks"), createDoor("door_nether_bricks", BlockSetType.STONE, Blocks.NETHER_BRICKS, Properties.of()));
      r.register(rl("door_red_nether_bricks"), createDoor("door_red_nether_bricks", BlockSetType.STONE, Blocks.RED_NETHER_BRICKS, Properties.of()));
      r.register(rl("door_purpur"), createDoor("door_purpur", BlockSetType.STONE, Blocks.PURPUR_BLOCK, Properties.of()));
      r.register(rl("door_sandstone"), createDoor("door_sandstone", BlockSetType.STONE, Blocks.SANDSTONE, Properties.of()));
      r.register(rl("door_red_sandstone"), createDoor("door_red_sandstone", BlockSetType.STONE, Blocks.RED_SANDSTONE, Properties.of()));
      r.register(rl("door_quartz"), createDoor("door_quartz", BlockSetType.STONE, Blocks.QUARTZ_BLOCK, Properties.of()));
      r.register(rl("door_red_mushroom"), createDoor("door_red_mushroom", BlockSetType.STONE, Blocks.RED_MUSHROOM_BLOCK, Properties.of()));
      r.register(rl("door_brown_mushroom"), createDoor("door_brown_mushroom", BlockSetType.STONE, Blocks.BROWN_MUSHROOM_BLOCK, Properties.of()));
      r.register(rl("door_end_stone"), createDoor("door_end_stone", BlockSetType.STONE, Blocks.END_STONE, Properties.of()));
      r.register(rl("door_end_stone_bricks"), createDoor("door_end_stone_bricks", BlockSetType.STONE, Blocks.END_STONE_BRICKS, Properties.of()));
      r.register(rl("door_obsidian"), createDoor("door_obsidian", BlockSetType.STONE, Blocks.OBSIDIAN, Properties.of()));
      r.register(rl("door_mossy_stone_bricks"), createDoor("door_mossy_stone_bricks", BlockSetType.STONE, Blocks.MOSSY_STONE_BRICKS, Properties.of()));
      r.register(rl("door_cracked_stone_bricks"), createDoor("door_cracked_stone_bricks", BlockSetType.STONE, Blocks.CRACKED_STONE_BRICKS, Properties.of()));
      r.register(rl("door_mud_bricks"), createDoor("door_mud_bricks", BlockSetType.STONE, Blocks.MUD_BRICKS, Properties.of()));
      r.register(rl("door_basalt"), createDoor("door_basalt", BlockSetType.STONE, Blocks.BASALT, Properties.of()));
      r.register(rl("door_deepslate"), createDoor("door_deepslate", BlockSetType.STONE, Blocks.DEEPSLATE, Properties.of()));
      r.register(rl("door_deepslate_bricks"), createDoor("door_deepslate_bricks", BlockSetType.STONE, Blocks.DEEPSLATE_BRICKS, Properties.of()));
      r.register(rl("door_deepslate_tiles"), createDoor("door_deepslate_tiles", BlockSetType.STONE, Blocks.DEEPSLATE_TILES, Properties.of()));
    });
    event.register(Registries.ITEM, r -> {
      for (BlockyDoor b : BLOCKLIST) {
        String id = b.getDescriptionId().replace(HAX, "");
        r.register(rl(id), createItem(b));
      }
    });
  }

  private static final ResourceKey<CreativeModeTab> TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(ModMain.MODID, "tab"));

  @SubscribeEvent
  public static void onCreativeModeTabRegister(RegisterEvent event) {
    event.register(Registries.CREATIVE_MODE_TAB, helper -> {
      helper.register(TAB, CreativeModeTab.builder().icon(() -> new ItemStack(DOOR_STONE))
          .title(Component.translatable("itemGroup." + ModMain.MODID))
          .displayItems((enabledFlags, populator) -> {
            for (Block b : BLOCKLIST) {
              populator.accept(b);
            }
          }).build());
    });
    //    event.registerCreativeModeTab(new Identifier(ModMain.MODID, "tab"), builder -> builder
    //        .title(Component.translatable("itemGroup." + ModMain.MODID))
    //        .icon(() -> new ItemStack(DOOR_STONE))
    //        .displayItems((enabledFlags, populator) -> {
    //          for (Block b : BLOCKLIST) {
    //            populator.accept(new ItemStack(b));
    //          }
    //        }));
  }

  private static final String HAX = "block." + ModMain.MODID + ".";

  private static Item createItem(BlockyDoor door) {
    return new BlockItem(door, new Item.Properties().useBlockDescriptionPrefix());
  }

  private static final List<BlockyDoor> BLOCKLIST = new ArrayList<>();

  public static BlockyDoor createDoor(String name, BlockSetType type, Block block, Block.Properties p) {
    BlockyDoor b = new BlockyDoor(BlockUtil.wrap(p, block, rl(name)), type);
    BLOCKLIST.add(b);
    return b;
  }

  private static Identifier rl(String name) {
    return Identifier.fromNamespaceAndPath(ModMain.MODID, name);
  }
}

package com.lothrazar.blockydoors;

import java.util.ArrayList;
import java.util.List;
import com.lothrazar.library.util.BlockUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRegistry {

  public static BlockyDoor DOOR_STONE;

  @SubscribeEvent
  public static void onBlocksRegistry(RegisterEvent event) {
    event.register(Registries.BLOCK, r -> {
      DOOR_STONE = createDoor(BlockSetType.STONE, Blocks.STONE, Properties.of());
      r.register("door_stone", DOOR_STONE);
      r.register("door_smooth_stone", createDoor(BlockSetType.ACACIA, Blocks.STONE, Properties.of()));
      r.register("door_cobblestone", createDoor(BlockSetType.ACACIA, Blocks.COBBLESTONE, Properties.of()));
      r.register("door_mossy_cobblestone", createDoor(BlockSetType.ACACIA, Blocks.MOSSY_COBBLESTONE, Properties.of()));
      r.register("door_stone_bricks", createDoor(BlockSetType.ACACIA, Blocks.STONE_BRICKS, Properties.of()));
      r.register("door_blackstone", createDoor(BlockSetType.ACACIA, Blocks.BLACKSTONE, Properties.of()));
      r.register("door_polished_blackstone_bricks", createDoor(BlockSetType.ACACIA, Blocks.POLISHED_BLACKSTONE_BRICKS, Properties.of()));
      r.register("door_granite", createDoor(BlockSetType.ACACIA, Blocks.GRANITE, Properties.of()));
      r.register("door_andesite", createDoor(BlockSetType.ACACIA, Blocks.ANDESITE, Properties.of()));
      r.register("door_diorite", createDoor(BlockSetType.ACACIA, Blocks.DIORITE, Properties.of()));
      r.register("door_bricks", createDoor(BlockSetType.ACACIA, Blocks.BRICKS, Properties.of()));
      r.register("door_prismarine", createDoor(BlockSetType.ACACIA, Blocks.PRISMARINE, Properties.of()));
      r.register("door_prismarine_bricks", createDoor(BlockSetType.ACACIA, Blocks.PRISMARINE_BRICKS, Properties.of()));
      r.register("door_dark_prismarine", createDoor(BlockSetType.ACACIA, Blocks.DARK_PRISMARINE, Properties.of()));
      r.register("door_netherrack", createDoor(BlockSetType.ACACIA, Blocks.NETHERRACK, Properties.of()));
      r.register("door_nether_bricks", createDoor(BlockSetType.ACACIA, Blocks.NETHER_BRICKS, Properties.of()));
      r.register("door_red_nether_bricks", createDoor(BlockSetType.ACACIA, Blocks.RED_NETHER_BRICKS, Properties.of()));
      r.register("door_purpur", createDoor(BlockSetType.ACACIA, Blocks.PURPUR_BLOCK, Properties.of()));
      r.register("door_sandstone", createDoor(BlockSetType.ACACIA, Blocks.SANDSTONE, Properties.of()));
      r.register("door_red_sandstone", createDoor(BlockSetType.ACACIA, Blocks.RED_SANDSTONE, Properties.of()));
      r.register("door_quartz", createDoor(BlockSetType.ACACIA, Blocks.QUARTZ_BLOCK, Properties.of()));
      r.register("door_red_mushroom", createDoor(BlockSetType.ACACIA, Blocks.RED_MUSHROOM_BLOCK, Properties.of()));
      r.register("door_brown_mushroom", createDoor(BlockSetType.ACACIA, Blocks.BROWN_MUSHROOM_BLOCK, Properties.of()));
      r.register("door_end_stone", createDoor(BlockSetType.ACACIA, Blocks.END_STONE, Properties.of()));
      r.register("door_end_stone_bricks", createDoor(BlockSetType.ACACIA, Blocks.END_STONE_BRICKS, Properties.of()));
      r.register("door_obsidian", createDoor(BlockSetType.ACACIA, Blocks.OBSIDIAN, Properties.of()));
      r.register("door_mossy_stone_bricks", createDoor(BlockSetType.ACACIA, Blocks.MOSSY_STONE_BRICKS, Properties.of()));
      r.register("door_cracked_stone_bricks", createDoor(BlockSetType.ACACIA, Blocks.CRACKED_STONE_BRICKS, Properties.of()));
    });
    event.register(Registries.ITEM, r -> {
      for (BlockyDoor b : BLOCKLIST) {
        String id = b.getDescriptionId().replace(HAX, "");
        r.register(id, createItem(b));
      }
    });
  }

  private static final ResourceKey<CreativeModeTab> TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(ModMain.MODID, "tab"));

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
    //    event.registerCreativeModeTab(new ResourceLocation(ModMain.MODID, "tab"), builder -> builder
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
    return new BlockItem(door, new Item.Properties());
  }

  private static final List<BlockyDoor> BLOCKLIST = new ArrayList<>();

  public static BlockyDoor createDoor(BlockSetType type, Block block, Block.Properties p) {
    BlockyDoor b = new BlockyDoor(BlockUtil.wrap(p, block), type);
    BLOCKLIST.add(b);
    return b;
  }
}

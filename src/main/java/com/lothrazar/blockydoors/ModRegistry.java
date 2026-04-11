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
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.RegisterEvent;

@EventBusSubscriber(modid = ModMain.MODID)//, bus = EventBusSubscriber.Bus.MOD !!
public class ModRegistry {

  public static BlockyDoor DOOR_STONE;

  @SubscribeEvent
  public static void onBlocksRegistry(RegisterEvent event) {
    event.register(Registries.BLOCK, r -> {
      DOOR_STONE = createDoor(BlockSetType.STONE, Blocks.STONE, Properties.of());
      r.register(rl("door_stone"), DOOR_STONE);
      r.register(rl("door_smooth_stone"), createDoor(BlockSetType.STONE, Blocks.STONE, Properties.of()));
      r.register(rl("door_cobblestone"), createDoor(BlockSetType.STONE, Blocks.COBBLESTONE, Properties.of()));
      r.register(rl("door_mossy_cobblestone"), createDoor(BlockSetType.STONE, Blocks.MOSSY_COBBLESTONE, Properties.of()));
      r.register(rl("door_stone_bricks"), createDoor(BlockSetType.STONE, Blocks.STONE_BRICKS, Properties.of()));
      r.register(rl("door_blackstone"), createDoor(BlockSetType.STONE, Blocks.BLACKSTONE, Properties.of()));
      r.register(rl("door_polished_blackstone_bricks"), createDoor(BlockSetType.STONE, Blocks.POLISHED_BLACKSTONE_BRICKS, Properties.of()));
      r.register(rl("door_granite"), createDoor(BlockSetType.STONE, Blocks.GRANITE, Properties.of()));
      r.register(rl("door_andesite"), createDoor(BlockSetType.STONE, Blocks.ANDESITE, Properties.of()));
      r.register(rl("door_diorite"), createDoor(BlockSetType.STONE, Blocks.DIORITE, Properties.of()));
      r.register(rl("door_bricks"), createDoor(BlockSetType.STONE, Blocks.BRICKS, Properties.of()));
      r.register(rl("door_prismarine"), createDoor(BlockSetType.STONE, Blocks.PRISMARINE, Properties.of()));
      r.register(rl("door_prismarine_bricks"), createDoor(BlockSetType.STONE, Blocks.PRISMARINE_BRICKS, Properties.of()));
      r.register(rl("door_dark_prismarine"), createDoor(BlockSetType.STONE, Blocks.DARK_PRISMARINE, Properties.of()));
      r.register(rl("door_netherrack"), createDoor(BlockSetType.STONE, Blocks.NETHERRACK, Properties.of()));
      r.register(rl("door_nether_bricks"), createDoor(BlockSetType.STONE, Blocks.NETHER_BRICKS, Properties.of()));
      r.register(rl("door_red_nether_bricks"), createDoor(BlockSetType.STONE, Blocks.RED_NETHER_BRICKS, Properties.of()));
      r.register(rl("door_purpur"), createDoor(BlockSetType.STONE, Blocks.PURPUR_BLOCK, Properties.of()));
      r.register(rl("door_sandstone"), createDoor(BlockSetType.STONE, Blocks.SANDSTONE, Properties.of()));
      r.register(rl("door_red_sandstone"), createDoor(BlockSetType.STONE, Blocks.RED_SANDSTONE, Properties.of()));
      r.register(rl("door_quartz"), createDoor(BlockSetType.STONE, Blocks.QUARTZ_BLOCK, Properties.of()));
      r.register(rl("door_red_mushroom"), createDoor(BlockSetType.STONE, Blocks.RED_MUSHROOM_BLOCK, Properties.of()));
      r.register(rl("door_brown_mushroom"), createDoor(BlockSetType.STONE, Blocks.BROWN_MUSHROOM_BLOCK, Properties.of()));
      r.register(rl("door_end_stone"), createDoor(BlockSetType.STONE, Blocks.END_STONE, Properties.of()));
      r.register(rl("door_end_stone_bricks"), createDoor(BlockSetType.STONE, Blocks.END_STONE_BRICKS, Properties.of()));
      r.register(rl("door_obsidian"), createDoor(BlockSetType.STONE, Blocks.OBSIDIAN, Properties.of()));
      r.register(rl("door_mossy_stone_bricks"), createDoor(BlockSetType.STONE, Blocks.MOSSY_STONE_BRICKS, Properties.of()));
      r.register(rl("door_cracked_stone_bricks"), createDoor(BlockSetType.STONE, Blocks.CRACKED_STONE_BRICKS, Properties.of()));
      r.register(rl("door_mud_bricks"), createDoor(BlockSetType.STONE, Blocks.MUD_BRICKS, Properties.of()));
      r.register(rl("door_basalt"), createDoor(BlockSetType.STONE, Blocks.BASALT, Properties.of()));
      r.register(rl("door_deepslate"), createDoor(BlockSetType.STONE, Blocks.DEEPSLATE, Properties.of()));
      r.register(rl("door_deepslate_bricks"), createDoor(BlockSetType.STONE, Blocks.DEEPSLATE_BRICKS, Properties.of()));
      r.register(rl("door_deepslate_tiles"), createDoor(BlockSetType.STONE, Blocks.DEEPSLATE_TILES, Properties.of()));
    });
    event.register(Registries.ITEM, r -> {
      for (BlockyDoor b : BLOCKLIST) {
        String id = b.getDescriptionId().replace(HAX, "");
        r.register(rl(id), createItem(b));
      }
    });
  }

  private static final ResourceKey<CreativeModeTab> TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(ModMain.MODID, "tab"));

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

  private static ResourceLocation rl(String name) {
    return ResourceLocation.fromNamespaceAndPath(ModMain.MODID, name);
  }
}

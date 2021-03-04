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

  @SubscribeEvent
  public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
    IForgeRegistry<Block> r = event.getRegistry();
    r.register(createDoor("door_stone", Blocks.BLACKSTONE, Properties.create(Material.ROCK)));
  }

  @SubscribeEvent
  public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
    IForgeRegistry<Item> r = event.getRegistry();
    r.register(new BlockItem(door_stone, new Item.Properties().group(itemGroup)).setRegistryName(door_stone.rawName()));
  }

  public static BlockyDoor createDoor(String name, Block block, Block.Properties p) {
    BlockyDoor b = new BlockyDoor(wrap(p, block), "door_stone");
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

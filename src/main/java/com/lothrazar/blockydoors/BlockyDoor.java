package com.lothrazar.blockydoors;

import net.minecraft.block.DoorBlock;

public class BlockyDoor extends DoorBlock {

  private final String rawName;

  public BlockyDoor(Properties p, String reg) {
    super(p);
    rawName = reg;
    setRegistryName(reg);
  }

  public String rawName() {
    return rawName;
  }
}

package com.endava.mmarko;

class Symbol {
  private final String label;
  private final int section;
  private final int offset;
  private boolean global;

  Symbol(String label, SectionLocation location, boolean global) {
    this.label = label;
    this.section = location.getId();
    this.offset = location.getOffset();
    this.global = global;
  }

  @Override
  public String toString() {
    String ret;
    String tabs = "\t\t\t";
    StringBuilder tabsName = new StringBuilder();

    for (int i = 0; i <= (23 - label.length()); i += 8)
      tabsName.append("\t");

    ret = label + tabsName.toString();

    if (section == -1) ret += "und";
    else ret += section;

    ret += (tabs + NumberParser.toHex(offset, 5) + tabs);

    if (global) ret += "global";
    else ret += "local";

    return ret;
  }

  String getLabel() {
    return label;
  }

  int getSection() {
    return section;
  }

  void setGlobal() {
    this.global = true;
  }
}

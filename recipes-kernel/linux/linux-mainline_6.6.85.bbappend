# meta-op3: override sunxi-kmeta files for Orange Pi 3 LTs
# op3-kmeta is prepended so its files take precedence over sunxi-kmeta
# when the kernel metadata search resolves patch and scc references.

FILESEXTRAPATHS:prepend := "${THISDIR}/linux-mainline:"
SRC_URI:prepend = "file://op3-kmeta;type=kmeta;name=op3-kmeta;destsuffix=op3-kmeta "
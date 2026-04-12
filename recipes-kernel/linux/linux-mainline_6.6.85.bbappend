# meta-op3: override sunxi-kmeta files for Orange Pi 3 LTs
# op3-kmeta is prepended so its files take precedence over sunxi-kmeta
# when the kernel metadata search resolves patch and scc references.

FILESEXTRAPATHS:prepend := "${THISDIR}/linux-mainline:"
SRC_URI:append = "file://sunxi-kmeta-op3;type=kmeta;name=sunxi-kmeta-op3"

KERNEL_FEATURES:remove:orange-pi-3lts = "bsp/orange-pi-3lts/orange-pi-3lts-6_5.scc"
KERNEL_FEATURES:prepend:orange-pi-3lts = "bsp/orange-pi-3lts/orange-pi-3lts-6_5_fixed.scc "

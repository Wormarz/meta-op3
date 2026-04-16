# meta-op3: kernel overrides for Orange Pi 3 LTS
#
# Strategy:
#   - Keep sunxi-kmeta as-is (provides uwe5622, fix-rtc, etc.)
#   - Append sunxi-kmeta-op3 as an additional kmeta directory.
#     spp sorts search paths by length (longest first), so
#     "sunxi-kmeta-op3" (15 chars) beats "sunxi-kmeta" (11 chars)
#     and same-named patch/scc files in sunxi-kmeta-op3 take precedence.
#   - Remove the upstream orange-pi-3lts-6_5.scc and prepend our fixed
#     version so it appears first (before uwe5622 and fix-rtc), matching
#     the original patch application order.

FILESEXTRAPATHS:prepend := "${THISDIR}/linux-mainline:"

SRC_URI:append = " file://sunxi-kmeta-op3;type=kmeta;name=sunxi-kmeta-op3"

KERNEL_FEATURES:remove:orange-pi-3lts = "bsp/orange-pi-3lts/orange-pi-3lts-6_5.scc"
KERNEL_FEATURES:prepend:orange-pi-3lts = "bsp/orange-pi-3lts/orange-pi-3lts-6_5_fixed.scc "

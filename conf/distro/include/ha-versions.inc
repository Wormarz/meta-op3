# Version preferences for Home Assistant 2026.2.0 build
# This ensures we use upstream (poky/meta-openembedded) packages where available,
# and our own meta-op3 recipes for packages not available upstream.
#
# IMPORTANT: meta-op3 has layer priority 11 (higher than meta=5, meta-python=5).
# So we must explicitly set PREFERRED_VERSION to force upstream versions
# when meta-op3 has an older version of the same package.

# ============================================================
# CRITICAL: Force packaging 24.2 from poky/meta over our old 23.1
# python3-hatchling-native (needed for systemd build) requires packaging>=24.2
# ============================================================
PREFERRED_VERSION:python3-packaging = "24.2"
PREFERRED_VERSION:python3-packaging-native = "24.2"

# ============================================================
# Force upstream versions to override older meta-op3 recipes
# ============================================================

# meta-python has 3.11.16, our meta-op3 has 3.8.5
PREFERRED_VERSION:python3-aiohttp = "3.11.16"

# meta has 25.3.0, our meta-op3 has 23.1.0
PREFERRED_VERSION:python3-attrs = "25.3.0"

# meta-python has 24.6.0, our meta-op3 has 23.8.0
PREFERRED_VERSION:python3-awesomeversion = "24.6.0"

# meta has 44.0.2, our meta-op3 has 41.0.4
PREFERRED_VERSION:python3-cryptography = "44.0.2"
PREFERRED_VERSION:python3-cryptography-native = "44.0.2"

# meta-python has 0.28.1, our meta-op3 has 0.25.0
PREFERRED_VERSION:python3-httpx = "0.28.1"

# meta-python has 1.3.0, our meta-op3 has 1.2.0
PREFERRED_VERSION:python3-lru-dict = "1.3.0"

# meta-python has 11.1.0, our meta-op3 has 10.1.0
PREFERRED_VERSION:python3-pillow = "11.1.0"

# meta-python has 2.10.1, our meta-op3 has 2.8.0
PREFERRED_VERSION:python3-pyjwt = "2.10.1"

# meta has 25.0.0, our meta-op3 has 23.2.0
PREFERRED_VERSION:python3-pyopenssl = "25.0.0"

# meta has 6.0.2, our meta-op3 has 6.0.1
PREFERRED_VERSION:python3-pyyaml = "6.0.2"

# meta has 2.32.4, our meta-op3 has 2.31.0
PREFERRED_VERSION:python3-requests = "2.32.4"

# meta-python has 2.0.40, our meta-op3 has 2.0.24
PREFERRED_VERSION:python3-sqlalchemy = "2.0.40"

# meta-python has 1.18.3, our meta-op3 has 1.9.2
PREFERRED_VERSION:python3-yarl = "1.18.3"

# meta-python has 0.146.3, our meta-op3 has 0.119.0
PREFERRED_VERSION:python3-zeroconf = "0.146.3"

# ============================================================
# These versions exist only in meta-op3 (no conflict with upstream)
# ============================================================
PREFERRED_VERSION:python3-astral = "2.2"
PREFERRED_VERSION:python3-atomicwrites-homeassistant = "1.4.1"
PREFERRED_VERSION:python3-ciso8601 = "2.3.0"
PREFERRED_VERSION:python3-home-assistant-bluetooth = "1.10.4"
PREFERRED_VERSION:python3-orjson = "3.9.9"
PREFERRED_VERSION:python3-python-slugify = "4.0.1"
PREFERRED_VERSION:python3-ulid-transform = "0.9.0"
PREFERRED_VERSION:python3-voluptuous = "0.13.1"
PREFERRED_VERSION:python3-voluptuous-serialize = "2.6.0"
PREFERRED_VERSION:python3-aiohttp-cors = "0.7.0"
PREFERRED_VERSION:python3-psutil-home-assistant = "0.0.1"
PREFERRED_VERSION:python3-securetar = "2023.3.0"

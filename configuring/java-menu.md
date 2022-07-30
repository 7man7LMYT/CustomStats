# Customizing the menu

*Note: This page only applies to the menu visible to Minecraft: Java Edition clients. For information on how to edit the Minecraft: Bedrock Edition form instead, head over to [this page](https://7man7lmyt.github.io/CustomStats/configuring/bedrock-form) instead.*


### Default Menu Configuration
```yaml
# Customize the menu sent to Minecraft: Java Edition clients.
stat-menu:
# Format for adding more GUI items:
# item(1-54):
#  - (Item type)
#  - "(display name)"
# Max slots are limited to menu-size.
# They are not required to be in order. Either set item type to air or don't set an item in the slot to leave blank.

# Must be a multiple of 9.
menu-size: 9

title: "&3Server Stats Menu"
items:
  3:
  - book
  - "&6This server was created on July 30, 2022."
  5:
  - grass_block
  - "&6The world is 12.34GB in size."
  7:
  - player_head
  - "&6Over %totalplayers% players have joined since."
```

## Adding more items
If you wish to add more items to the menu, you simply need to follow the following format.
```yaml
(slot number):
  - (item)
  - (item name)
```
Slots do not have to be in order at all, neither do you have to set a slot to air if you wish to not use said slot. Keep in mind, if you wish to use slots higher than the default 9, you must change the `menu-size` option. The number must be a multiple of 9, otherwise the inventory will not be created.
(Supported sizes: `9, 18, 27, 36, 45, 54`).
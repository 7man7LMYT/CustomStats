# Customizing the menu

*Note: This page only applies to the menu visible to Minecraft: Java Edition clients. For information on how to edit the Minecraft: Bedrock Edition form instead, head over to [this page](https://7man7lmyt.github.io/CustomStats/configuring/bedrock-form) instead.*


### Default Menu Configuration
```yaml
  # Customize the menu sent to Minecraft: Java Edition clients.
  stat-menu:
    # Format for adding more items to the GUI:
    # (0-53):
    #  - (Item type)
    #  - "(display name)"
    #  - "(item lore)"
    #  - "(more item lore)"

    # Maximum inventory slots are limited by 'menu-size'.
    # The items are not required to be in order.
    # Either set the item type to air or remove the slot to leave blank.
    # Slot #0 is an exception, you have to set it to air if you wish to set nothing in the slot.

    # Must be a multiple of 9.
    menu-size: 9

    title: "&3Server Stats Menu"
    items:
      0:
        - book
        - "&6This server was created on July 30, 2022."
        - "&6The world is 12.34GB in size."
        - "&6%totalplayers% unique players have joined since."
```

## Adding more items

Notice: Due to how the configuration is handled, it ends up falling back onto the default value set in the configuration originally if it's not present. 
To get around this issue, I picked Slot #0 as the slot to be the only item present in a default configuration. If you wish to not use Slot #0, you can simply have it's material set to 'air'. This effectively removes the item.

If you wish to add more items to the menu, you simply need to follow the following format.
```yaml
(slot number):
  - (item type)
  - (display name)
  - (display lore)
  - (display lore 2)
```
Slots do not have to be in order at all, neither do you have to set a slot to air if you wish to not use said slot. Keep in mind, if you wish to use slots higher than the default 9, you must change the `menu-size` option. The number must be a multiple of 9, otherwise the inventory will not be created.
(Supported sizes: `9, 18, 27, 36, 45, 54`).


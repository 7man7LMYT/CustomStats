# Customizing the form

*Note: This page applies to the form visible to Minecraft: Bedrock Edition clients. For information on how to edit the Minecraft: Java Edition menu instead, head over to [this page](https://7man7lmyt.github.io/CustomStats/configuring/java-menu) instead.*


### Default Form Configuration
*This section is from the plugin config v2.0.0. For a mode up to date configuration, please head to [here](https://github.com/7man7LMYT/CustomStats/blob/main/src/main/resources/config.yml).*
```yaml
# Customize the form sent to Minecraft: Bedrock Edition clients. (Will only work if you have GeyserMC + Floodgate!)
stat-form:
# Format for adding more lines to the form:
# content:
#   - "&6This text is gold!"
#   - "&lThis text is bold!"
#   - "&0R&1a&2i&3n&4b&5o&6w &7C&8o&9l&ao&br&cs&d!&e!&f!

title: "&3Server Stats Menu"
content:
    - "&a--------------------------------"
    - "&6This server was created on July 30, 2022."
    - "&6The world is 12.34GB in size."
    - "&6Over %totalplayers% players have joined since."
    - "&a--------------------------------"
```

## Adding more lines
To add more lines to the form, simply follow the same format as shown in the configuration. The plugin supports the use of `&` and `§` color codes.
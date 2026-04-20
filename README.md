# ![Logo](https://cdn.minevalley.eu/branding/logo_64px_cropped.png) - CraftingAPI

The CraftingAPI provides access to create custom crafting recipes (shaped and shapeless) for MineValleyEU

## Maven Integration

To use this API in your module, we provide a Maven repository hosted on GitHub.  
Before proceeding, ensure you've added a token to your `settings.xml` file (details below).

```xml
<repository>
    <id>CraftingAPI</id>
    <url>https://maven.pkg.github.com/MineValley/CraftingAPI</url>
</repository>
```

```xml
<dependency>
    <groupId>eu.minevalley</groupId>
    <artifactId>crafting-api</artifactId>
    <version>1.0.0</version>
    <scope>provided</scope>
</dependency>
```

# `FSMChamp`

> FSMChamp is a simple yet elegant and powerful state machine library based on [Minikloon's FSMgasm](https://github.com/Minikloon/FSMgasm).

## What does FSMChamp solve?

While using FSMgasm I've quickly fallen in love with the state-based minigame development. While using states themselves leads to no issues, the implementation of Minikloon seems to lack in certain aspects.

- **Timer Desync**: The duration system kloon has implemented is very elegant, but because Bukkit runs on ticks instead of time, stuff tends to desync. Because of this I decided to not abstract the timer aspect of the state machine. You just specify how many ticks your state will take and the state will automatically decrease said ticks.
- **Change Time Left**: In FSMgasm the time left is completely stuck. You cannot add or remove time. Since FSMChamp's implementation is just an integer going down, you can just add or remove from that integer all you like.

## Real world usages

- This framework is a modification of the framework I've battle tested in [Minestars](https://twitter.com/MineStars_). There are a few small differences, but they are mostly the same.

- Alongside Minestars I'm currently also using it in [StomMiniGames](https://github.com/SimplyMerlin/StomMiniGames). This is why the framework isn't specifically made for spigot. I wanted to be able to use it in Minestom as well.
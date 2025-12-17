---
navigation:
  title: Estabilizador
  icon: "justdynathings:stabilizer"
  position: 3
  parent: justdynathings:other.md
item_ids:
  - justdynathings:stabilizer
---

# Estabilizador

Ele pode reviver qualquer gosma em cima dele usando Energia Forge

<BlockImage id="justdynathings:stabilizer" scale="4.0" p:active="false" p:facing="down" p:goo_found="false"/>

Um exemplo de Estabilizador de Gosma alimentado abaixo de um Gosma de Blazebloom revitalizado

<GameScene zoom="4" interactive={true}>
  <Block id="justdynathings:stabilizer" p:active="true" p:facing="down" p:goo_found="true"/>
  <Block y="1" id="justdirethings:gooblock_tier2" p:alive="true"/>
</GameScene>

Também pode ser usado para manter vivo um Misturador de Paradoxos quando Energizado (usando Fluido Temporal)

<GameScene zoom="4" interactive={true}>
  <Block id="justdynathings:stabilizer" p:active="true" p:facing="down" p:goo_found="true" p:energized="true"/>
  <Block y="1" id="justdynathings:paradox_mixer" p:alive="true"/>
</GameScene>

<Recipe id="justdynathings:stabilizer" />
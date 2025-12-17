---
navigation:
  title: Misturador de Paradoxo
  icon: "justdynathings:paradox_mixer"
  position: 7
  parent: justdynathings:other.md
item_ids:
  - justdynathings:paradox_mixer
---

# Misturador de Paradoxo

Um bloco _instável_ que permite a fabricação em massa de receitas de gotas de fluido

<BlockImage id="justdynathings:paradox_mixer" scale="4.0" p:alive="false"/>
<BlockImage id="justdynathings:paradox_mixer" scale="4.0" p:alive="true"/>

Ele requer pelo menos um Estabilizador energizado para permanecer vivo

<GameScene zoom="4" interactive={true}>
  <Block id="justdynathings:stabilizer" p:active="true" p:facing="down" p:goo_found="true" p:energized="true"/>
  <Block y="1" id="justdynathings:paradox_mixer" p:alive="true"/>
</GameScene>

<Recipe id="justdynathings:paradox_mixer" />
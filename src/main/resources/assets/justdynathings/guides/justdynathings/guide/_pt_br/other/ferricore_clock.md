---
navigation:
  title: Relógio de Ferricore
  icon: "justdynathings:ferricore_clock"
  position: 4
  parent: justdynathings:other.md
item_ids:
  - justdynathings:ferricore_clock
---

# Relógios de redstone totalmente configuráveis

# Relógio de Ferricore

_também conhecido como Relógio de Redstone_

Um bloco que pode ser programado para alimentar componentes de redstone em qualquer lado configurável com um gametick específico

<BlockImage id="justdynathings:ferricore_clock" p:north="true" p:south="true" p:east="true" p:west="true" p:up="true" p:down="true" p:active="false" scale="4.0"/>

<BlockImage id="justdynathings:ferricore_clock" p:north="true" p:south="true" p:east="true" p:west="true" p:up="true" p:down="true" p:active="true" scale="4.0"/>

Relógio de Ferricore com as direções NORTE e CIMA desativadas para evitar alimentar o que não é desejado

<GameScene zoom="4" interactive={true}>

  <Block id="justdynathings:ferricore_clock" p:north="false" p:south="false" p:east="true" p:west="true" p:up="false" p:down="true" p:active="true"/>

  <Block y="1" id="minecraft:redstone_torch" p:lit="true"/>

  <Block y="-1" id="minecraft:redstone_lamp" p:lit="true"/>

  <Block x="1" id="minecraft:repeater" p:powered="true" p:locked="false" p:delay="1" p:facing="west"/>

  <Block z="1" id="minecraft:repeater" p:powered="false" p:locked="false" p:delay="1" p:facing="north"/>

  <Block z="-1" id="minecraft:repeater" p:powered="false" p:locked="false" p:delay="1" p:facing="south"/>

  <Block x="-1" id="minecraft:repeater" p:powered="true" p:locked="false" p:delay="1" p:facing="east"/>

</GameScene>

<Recipe id="justdynathings:ferricore_clock" />
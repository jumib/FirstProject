<template>
  <v-container fluid>
    <v-content>
      <v-row>
        <v-col
          v-for="card in cards"
          :key="card.title"
          :cols="card.flex"
        >
            <v-img
              :src="card.src"
              class="align-end"
              height="300px"
              width="300px"
            >
            </v-img>
        </v-col>
      </v-row>
    </v-content>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    cards: [
      { title: 'Pre-fab homes', src: 'https://cdn.vuetifyjs.com/images/cards/house.jpg', flex: 4, clicked: false },
      { title: 'Favorite road trips', src: 'https://cdn.vuetifyjs.com/images/cards/road.jpg', flex: 4, clicked: false },
      { title: 'Best airlines', src: 'https://cdn.vuetifyjs.com/images/cards/plane.jpg', flex: 4, clicked: false }
    ]
  })
}
</script>

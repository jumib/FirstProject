<template>
  <v-footer
  app
  color="#000000"
  dark
  class="white--text"
  >
    <v-card
    flat
    tile
    class="black white--text text-center"
    dark
    >
      <v-card-text>
        <v-btn
        v-for="icon in icons"
        :key="icon"
        class="mx-4 white--text"
        icon
        @click="movelink(icon.url)"
        >
          <v-icon size="20px" >{{ icon.name }}</v-icon>
        </v-btn>
      </v-card-text>
      <v-card-text class="white--text pt-0">
        Phasellus feugiat arcu sapien, et iaculis ipsum elementum sit amet. Mauris cursus commodo interdum. Praesent ut risus eget metus luctus accumsan id ultrices nunc.
        Sed at orci sed massa consectetur dignissim a sit amet dui. Duis commodo vitae velit et faucibus. Morbi vehicula lacinia malesuada.
        Nulla placerat augue vel ipsum ultrices, cursus iaculis dui sollicitudin. Vestibulum eu ipsum vel diam elementum tempor vel ut orci. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
      </v-card-text>
      <v-divider></v-divider>
      <v-card-text class="white--text">
      {{ new Date().getFullYear() }} — <strong>interior</strong>
      </v-card-text>
    </v-card>
  </v-footer>
</template>

<script>
export default {
  data: () => ({
    drawer: false,
    left: false,
    icons: [
      { name: 'mdi-facebook', url: 'https://www.facebook.com' },
      { name: 'mdi-twitter', url: 'https://twitter.com' },
      { name: 'mdi-linkedin', url: 'https://www.instagram.com' },
      { name: 'mdi-instagram', url: 'https://kr.linkedin.com' }
    ]
  }),
  methods: {
    movelink: function (url) {
      window.open(url)
    }
  }
}
</script>

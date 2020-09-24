<template>
  <v-footer
    dark
    padless
    app
  >
    <v-card
      class="flex"
      flat
      tile
    >
      <v-card-title>
        <strong class="subheading">Get connected with us on social networks!</strong>

        <v-spacer></v-spacer>

        <v-btn
          v-for="icon in icons"
          :key="icon"
          class="mx-4"
          icon
          @click="movelink(icon.url)"
        >
          <v-icon size="24px">{{ icon.name }}</v-icon>
        </v-btn>
      </v-card-title>
      <v-divider></v-divider>

      <v-card-text class="py-2 white--text text-center">
              {{ new Date().getFullYear() }} — <strong>lucys</strong>
            </v-card-text>
    </v-card>
  </v-footer>
</template>

<script>
export default {
  data: () => ({
    icons: [
      { name: 'mdi-facebook', url: 'https://www.facebook.com' },
      { name: 'mdi-twitter', url: 'https://twitter.com' },
      { name: 'mdi-linkedin', url: 'https://kr.linkedin.com' },
      { name: 'mdi-instagram', url: 'https://www.instagram.com' }
    ]
  }),
  methods: {
    movelink: function (url) {
      window.open(url)
    }
  }
}
</script>

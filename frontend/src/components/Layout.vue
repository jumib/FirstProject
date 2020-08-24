<template>
  <v-app id="inspire">
    <v-card class="overflow-hidden">
      <v-app-bar
        absolute
        color="white"
        elevate-on-scroll
        scroll-target="#scrolling-techniques-7"
      >
        <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
        <v-spacer></v-spacer>
        <v-text-field
                append-icon=""
                class="mx-4"
                flat
                hide-details
                label="Search"
                prepend-inner-icon=""
                solo-inverted
              ></v-text-field>
        <v-spacer></v-spacer>
        <slot name="menubar"></slot>
      </v-app-bar>
      <v-container>
        <v-content id="content">
        </v-content>
      </v-container>

    </v-card>

    <v-footer
      app
      color=""
      class="white--text"
    >
    <v-card
        flat
        tile
        class="black lighten-1 white--text text-center"
      >
        <v-card-text>
          <v-btn
            v-for="icon in icons"
            :key="icon"
            class="mx-4 white--text"
            icon
          >
            <v-icon size="20px">{{ icon }}</v-icon>
          </v-btn>
        </v-card-text>

        <v-card-text class="white--text pt-0">
         Phasellus feugiat arcu sapien, et iaculis ipsum elementum sit amet. Mauris cursus commodo interdum. Praesent ut risus eget metus luctus accumsan id ultrices nunc. Sed at orci sed massa consectetur dignissim a sit amet dui. Duis commodo vitae velit et faucibus. Morbi vehicula lacinia malesuada. Nulla placerat augue vel ipsum ultrices, cursus iaculis dui sollicitudin. Vestibulum eu ipsum vel diam elementum tempor vel ut orci. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
        </v-card-text>

        <v-divider></v-divider>

        <v-card-text class="white--text">
          {{ new Date().getFullYear() }} — <strong>jumi jjang</strong>
        </v-card-text>
      </v-card>
    </v-footer>

  </v-app>
</template>

<script>
export default {
  data: () => ({
    icons: [
      'mdi-facebook',
      'mdi-twitter',
      'mdi-linkedin',
      'mdi-instagram'
    ]
  })
}
</script>

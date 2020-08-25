<template>
  <v-app id="inspire">
    <v-card class="overflow-hidden">
      <v-app-bar
        absolute
        color="white"
        elevate-on-scroll
        scroll-target="#scrolling-techniques-7"
      >

        <v-app-bar-nav-text @click.stop="drawer = !drawer">
         click me !
        </v-app-bar-nav-text>
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

        <!-- <slot name="menubar">
        </slot> 슬롯 일단 숨겨놓기 (로그인, 회원가입 버튼)-->

        <!-- 여기부터 우측 상단 아이콘 -->
          <v-on icon @click="$router.push('FavorPage')">
            <v-icon color="#FF7043">mdi-heart</v-icon>
          </v-on>

          <v-menu
            bottom
            left
          >
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                icon
                color="#FF7043"
                v-bind="attrs"
                v-on="on"
              >
                <v-icon>mdi-dots-vertical</v-icon>
              </v-btn>
            </template>

            <v-list>
              <v-list-item
                v-for="(item, i) in items"
                :key="i"
                >
                <v-list-item-title>{{ item.title }}
                </v-list-item-title>
              </v-list-item>
            </v-list>
          </v-menu>
          <!-- 여기까지 -->
      </v-app-bar>

      <!-- 여기부터 왼쪽 바 -->
      <template>
           <!-- 요거는 왼쪽 상간 타이틀 쪽 메뉴바 의미, 필요한 옵션을 적절히 활용하면 됨(예제참고) -->
            <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
            <v-toolbar-title><div @click="home">Crawl Project</div></v-toolbar-title>
            <v-spacer></v-spacer>
          <v-navigation-drawer
            v-model="drawer"
            app
          >
            <v-list dense>
              <v-list-item @click.stop="left = !left">
                <v-list-item-action>
                  <v-icon>mdi-exit-to-app</v-icon>
                </v-list-item-action>
                <v-list-item-content>
                  <v-list-item-title @click="home">Home</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list>

            <v-list dense>
              <v-list-item @click.stop="left = !left">
                <v-list-item-action>
                  <v-icon>mdi-exit-to-app</v-icon>
                </v-list-item-action>
                <v-list-item-content>
                  <v-list-item-title @click="category">Category</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list>

            <v-list dense>
              <v-list-item @click.stop="left = !left">
                <v-list-item-action>
                  <div>>>></div>
                </v-list-item-action>
                <v-list-item-content>
                  <v-list-item-title @click="suggest">Suggest</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list>

            <v-list dense>
              <v-list-item @click.stop="left = !left">
                <v-list-item-action>
                  <v-icon>mdi-exit-to-app</v-icon>
                </v-list-item-action>
                <v-list-item-content>
                  <v-list-item-title @click="savednews()">Saved</v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list>
          </v-navigation-drawer>
          </template>
          <!-- 여기까지 왼쪽 바 -->

          <!-- 여기부터 메인 이미지파일 -->
          <template>
          <br>
          <br>
            <v-row align="center" justify="center">
              <v-img
                :src="require('/home/bitai/Downloads/wood.jpeg')"
                class="my-3"
                contain
                max-width="300"
                max-height="400"
              />
              <v-col cols="center" sm="center">
              <v-img
                :src="require('/home/bitai/Downloads/wood2.jpg')"
                class="my-3"
                max-width="300"
                max-height="400"
              />
               <v-img
                :src="require('/home/bitai/Downloads/wood3.jpg')"
                class="my-3"
                max-width="300"
                max-height="400"
              />
              </v-col>

                <template v-slot:placeholder>
                  <v-row
                    class="fill-height ma-0"
                    align="center"
                    justify="center"
                  >
                    <v-progress-circular indeterminate color="grey lighten-5"></v-progress-circular>
                  </v-row>
                </template>
            </v-row>
          </template>
          <!-- 여기까지 메인 이미지파일 -->

      <v-container>
        <v-content id="content">
        </v-content>
      </v-container>

    </v-card>

    <v-footer
      app
      color="#FF7043"
      class="white--text"
    >
    <v-card
        flat
        tile
        class="deep-orange lighten-1 white--text text-center"
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
import router from '../router'

export default {
  data: () => ({
    drawer: false,
    left: false,
    icons: [
      'mdi-facebook',
      'mdi-twitter',
      'mdi-linkedin',
      'mdi-instagram'
    ],
    items: [
      { title: 'my page' },
      { title: 'my board' },
      { title: 'logout' },
      { title: 'c/s' }
    ]
  }),
  methods: {
    home () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    },
    category () {
      (window.location.pathname !== '/CrawlCategory') ? router.push('/CrawlCategory') : router.go(0)
    },
    suggest () {
      (window.location.pathname !== '/suggestednews/list') ? router.push('/suggestednews/list') : router.go(0)
    },
    savednews () {
      (window.location.pathname !== '/savednews/list') ? router.push('/savednews/list') : router.go(0)
    }
  }
}
</script>

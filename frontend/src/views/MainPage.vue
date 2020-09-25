<template>
    <v-content id="content">
      <slot name="content" class="font">
        <v-row justify="center">
          <v-img
            :src="require('/Users/jumibaek/Downloads/miniproj/99.jpeg')"
            width="1500"
            height="900"
          />
        </v-row>
      </slot>
    </v-content>
</template>

<script>
export default {
  data () {
    return {
      like: 0
    }
  }
}
</script>

<style scoped lang="scss">
#bg{
  // 이미지가 로고와 텍스트 포함해서 어두워짐
  filter: brightness(50%);
}
</style>

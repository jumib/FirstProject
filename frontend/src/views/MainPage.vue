<template>
  <v-container>
    <v-content id="content">
      <slot name="content" class="font">
        <v-row justify="center">
          <v-img
            :src="require('/home/bitai/Downloads/main.jpeg')"
            width="1000"
            height="850"
          />
        </v-row>
      </slot>
    </v-content>
  </v-container>
</template>

<script>
</script>

<style scoped lang="scss">
#bg{
  // 이미지가 로고와 텍스트 포함해서 어두워짐
  filter: brightness(50%);
}
</style>

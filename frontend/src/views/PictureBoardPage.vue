<template>
  <div>{{ 사진 }}
      <picture-page :boards="boards"/>
  </div>
</template>

<script>
import PicturePage from '@/components/PicturePage'

export default {
  name: 'PictureBoardPage',
  components: {
    PicturePage
  }
}
</script>

<template>
  <v-container>
    <v-content>
 <div class="ma-16" align="center">
    <h2>Upload</h2>
    <br>
    <br>
    <div class="my-2" align="right">
      <PondRegisterForm/>
    </div>
 </div>
  </v-content>
   </v-container>
</template>

<script>
import PondRegisterForm from '@/components/PondRegisterForm.vue'

export default {
  name: 'PondRegisterPage',
  components: {
    PondRegisterForm
  }
}
</script>

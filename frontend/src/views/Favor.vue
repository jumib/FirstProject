<template>
  <v-container>
    <v-content>
 <div class="ma-16" align="center">
       <h2 style="color:#66BB6A">Favor board</h2>
       <br>
       <br>
      <FavorForm/>
 </div>
  </v-content>
   </v-container>
</template>

<script>
import FavorForm from '@/components/FavorForm.vue'

export default {
  name: 'Favor',
  components: {
    FavorForm
  }
}
</script>

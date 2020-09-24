<template>
  <v-container>
    <v-content>
 <div class="ma-16" align="center">
       <h2>Picture board</h2>
       <br>
       <br>
      <v-btn depressed small @click="$router.push('PondRegisterPage')" color="#000000" dark>file upload
        <v-icon>mdi-upload</v-icon>
      </v-btn>
      <PondListForm/>
 </div>
  </v-content>
   </v-container>
</template>

<script>
import PondListForm from '@/components/PondListForm.vue'

export default {
  name: 'PondListPage',
  components: {
    PondListForm
  }
}
</script>

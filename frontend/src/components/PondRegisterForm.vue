<template>
  <v-container>
    <v-row justify="center">
      <v-col cols="3">
        <file-pond
        name="test"
        ref="pond"
        label-idle="Drop files here !"
        allow-multiple="true"
        accepted-file-types="image/jpeg, image/png"
        server="http://localhost:7777/files"
        v-on:init="handleFilePondInit"/>
      </v-col>
      <v-col cols="3">
        <v-textarea
          counter
          color="cyan"
          label="content"
          :rules="rules"
          :value="value"
        ></v-textarea>
      </v-col>
    </v-row>
    <br>
    <v-row justify="center">
      <v-btn depressed small @click="$router.push('PondListPage')" color="green" dark>complete</v-btn>
    </v-row>
    <br>
    <v-row justify="center">
      <v-btn depressed small color="green"
             @click="$router.push('PondListPage')">back</v-btn>
    </v-row>
  </v-container>
</template>

<script>
import vueFilePond from 'vue-filepond'
import 'filepond/dist/filepond.min.css'

import 'filepond-plugin-image-preview/dist/filepond-plugin-image-preview.min.css'

import FilePondPluginFileValidateType from 'filepond-plugin-file-validate-type'
import FilePondPluginImagePreview from 'filepond-plugin-image-preview'

const FilePond = vueFilePond(
  FilePondPluginFileValidateType,
  FilePondPluginImagePreview
)
export default {
  name: '',
  data: function () {
    return {
      rules: [v => v.length <= 25 || 'Max 25 characters'],
      value: 'Hello!'
    }
  },
  methods: {
    handleFilePondInit: function () {
      console.log('FilePond has initialized')
    }
  },
  components: {
    FilePond
  }
}
</script>

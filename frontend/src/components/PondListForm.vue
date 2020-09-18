<template>
  <div>
    <file-pond
      name="test"
      ref="pond"
      label-idle="Drop files here !"
      allow-multiple="true"
      accepted-file-types="image/jpeg, image/png"
      server="/files"
      v-bind:files="myFiles"
      v-on:init="handleFilePondInit"/>
  </div>
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
      myFiles: [{
        source: 'photo.jpeg',
        options: {
          type: 'local'
        }
      }]
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

<template>
  <div align="center">
  upload your pictures!
  <picture-board-form @submit="onSubmit" />
    </div>
</template>
// import PictureBoardForm from '@/components/PictureBoardForm'
//import axios from 'axios'
// export default {
//   name: 'PictureBoardPage',
//   components: {
//     PictureBoardForm
//   },
//   methods: {
//     onSubmit (payload) {
//       console.log('loginPage onSubmit()')
//      this.ooooo(payload).then(res => {
//         alert('Login Success')
//        this.$router.push({ name: 'MainPage' })
//       }).catch(err => {
        // alert(err.response.data.message)
//        alert('Something Fail: ', err)
//      })
//    },
//    ...mapActions(['ooooo'])
//  }
// }

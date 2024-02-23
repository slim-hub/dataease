<template>
  <de-layout-content>
    <div class="sys-setting">
      <el-tabs
        v-model="activeName"
        class="de-tabs"
        @tab-click="handleClick"
      >
        <el-tab-pane
          lazy
          :label="$t('role.role_list')"
          name="zero"
        />

        <el-tab-pane
          lazy
          :label="$t('role.data_authorization')"
          name="first"
        />
        </el-tabs>
    </div>
    <div
        class="tabs-container">
        <role-list v-if="activeName === 'zero'" />
        <role-auth v-if="activeName === 'frist'" />
    </div>
  </de-layout-content>

</template>

<script>

import DeLayoutContent from '@/components/business/DeLayoutContent'
export default {
  components: { DeLayoutContent },
  data() {
    return {
      activeName: 'zero',
    }
  },

  methods: {
    handleClick() {
        console.log(this.activeName)
      
    }
  }
}

</script>

<style>

</style>
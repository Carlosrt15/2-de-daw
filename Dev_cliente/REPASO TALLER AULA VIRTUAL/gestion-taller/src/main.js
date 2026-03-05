import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(createPinia())
app.use(router)

app.mount('#app')

/**
 * 
 * npx json-server --watch data.json --port 3000
   Para escuchcar json server
 * 
 */

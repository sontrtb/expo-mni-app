import { registerWebModule, NativeModule } from 'expo';

import { ExpoMiniAppModuleEvents } from './ExpoMiniApp.types';

class ExpoMiniAppModule extends NativeModule<ExpoMiniAppModuleEvents> {
  PI = Math.PI;
  async setValueAsync(value: string): Promise<void> {
    this.emit('onChange', { value });
  }
  hello() {
    return 'Hello world! 👋';
  }
}

export default registerWebModule(ExpoMiniAppModule, 'ExpoMiniAppModule');

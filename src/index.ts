// Reexport the native module. On web, it will be resolved to ExpoMiniAppModule.web.ts
// and on native platforms to ExpoMiniAppModule.ts
export { default } from './ExpoMiniAppModule';
export { default as ExpoMiniAppView } from './ExpoMiniAppView';
export * from  './ExpoMiniApp.types';

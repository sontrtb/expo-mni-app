import { requireNativeView } from 'expo';
import * as React from 'react';

import { ExpoMiniAppViewProps } from './ExpoMiniApp.types';

const NativeView: React.ComponentType<ExpoMiniAppViewProps> =
  requireNativeView('ExpoMiniApp');

export default function ExpoMiniAppView(props: ExpoMiniAppViewProps) {
  return <NativeView {...props} />;
}

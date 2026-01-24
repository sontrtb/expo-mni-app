import * as React from 'react';

import { ExpoMiniAppViewProps } from './ExpoMiniApp.types';

export default function ExpoMiniAppView(props: ExpoMiniAppViewProps) {
  return (
    <div>
      <iframe
        style={{ flex: 1 }}
        src={props.url}
        onLoad={() => props.onLoad({ nativeEvent: { url: props.url } })}
      />
    </div>
  );
}

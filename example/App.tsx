import { useEvent } from 'expo';
import ExpoMiniApp, { ExpoMiniAppView } from 'expo-mini-app';
import { Button, SafeAreaView, ScrollView, Text, View } from 'react-native';

export default function App() {
  const onChangePayload = useEvent(ExpoMiniApp, 'onChange');

  return (
    <SafeAreaView style={styles.container}>
      <ExpoMiniAppView
        url="https://www.example.com"
        onLoad={({ nativeEvent: { url } }) => console.log(`Loaded: ${url}`)}
        style={styles.view}
      />
    </SafeAreaView>
  );
}

function Group(props: { name: string; children: React.ReactNode }) {
  return (
    <View style={styles.group}>
      <Text style={styles.groupHeader}>{props.name}</Text>
      {props.children}
    </View>
  );
}

const styles = {
  header: {
    fontSize: 30,
    margin: 20,
  },
  groupHeader: {
    fontSize: 20,
    marginBottom: 20,
  },
  group: {
    backgroundColor: '#fff',
    borderRadius: 10,
    padding: 20,
  },
  container: {
    flex: 1,
    backgroundColor: 'red',
  },
  view: {
    flex: 1,
    height: 700,
  },
};

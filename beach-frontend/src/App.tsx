import React from 'react';
import { useBeachForecast } from './hooks/useBeachForecast';

function App() {
  const { data, isLoading, error } = useBeachForecast();

  if (isLoading) return <div>로딩 중...</div>;
  if (error) return <div>에러 발생!</div>;

  return (
    <div>
      <h1>해수욕장 단기 예보</h1>
      <pre>{JSON.stringify(data, null, 2)}</pre>
    </div>
  );
}

export default App;

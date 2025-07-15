import React from 'react';
import { useBeachForecast } from './hooks/useBeachForecast';

function App() {
  const { data, isLoading, error } = useBeachForecast();

  const labelMap = {
    beachNum: '해변코드',
    baseDate: '발표일자',
    baseTime: '발표시각',
    category: '자료구분코드',
    fcstDate: '예보일자',
    fcstTime: '예보시간',
    fcstValue: '예보 값',
    nx: 'X좌표',
    ny: 'Y좌표',
  };
  const items = (data as any)?.response?.body?.items?.item ?? [];

  if (isLoading) return <div>로딩 중...</div>;
  if (error) return <div>에러 발생!</div>;

  return (
    <div>
      <h1>해수욕장 단기 예보</h1>
      {items.map((item: any, idx: number) => (
        <div
          key={idx}
          style={{ border: '1px solid #ccc', padding: 10, marginBottom: 10 }}
        >
          <div>예보일자: {item.fcstDate}</div>
          <div>예보시간: {item.fcstTime}</div>
          <div>자료구분코드: {item.category}</div>
          <div>예보 값: {item.fcstValue}</div>
        </div>
      ))}
    </div>
  );
}

export default App;

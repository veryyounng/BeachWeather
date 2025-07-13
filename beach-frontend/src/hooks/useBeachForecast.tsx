import { useQuery } from '@tanstack/react-query';
import axiosInstance from '../libs/axios';

const fetchBeachForecast = async () => {
  const { data } = await axiosInstance.get('/api/beach/ultra');
  return data;
};

export const useBeachForecast = () => {
  return useQuery({
    queryKey: ['beachForecast'],
    queryFn: fetchBeachForecast,
  });
};

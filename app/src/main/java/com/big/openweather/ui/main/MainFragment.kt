package com.big.openweather.ui.mainimport android.content.Contextimport android.os.Bundleimport android.view.LayoutInflaterimport android.view.Viewimport android.view.ViewGroupimport android.view.inputmethod.EditorInfoimport android.view.inputmethod.InputMethodManagerimport android.widget.EditTextimport android.widget.Toastimport androidx.appcompat.widget.SearchViewimport androidx.fragment.app.Fragmentimport androidx.lifecycle.Observerimport androidx.recyclerview.widget.GridLayoutManagerimport androidx.recyclerview.widget.RecyclerViewimport com.big.openweather.Rimport com.big.openweather.data.remote.response.weatherdetails.listimport dagger.hilt.android.AndroidEntryPointimport kotlinx.android.synthetic.main.main_fragment.*import javax.inject.Inject@AndroidEntryPointclass MainFragment : Fragment() {    @Inject    lateinit var mViewModel: MainViewModel    private lateinit var mSearchView: SearchView    private lateinit var mSearchPlate: EditText    private lateinit var mMovieRV: RecyclerView    private lateinit var mWeatherAdapter: WeatherAdapter    private var weatherList = mutableListOf<list>()    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,                              savedInstanceState: Bundle?): View? {        val root = inflater.inflate(R.layout.main_fragment, container, false)        setUpView(root)        mSearchPlate.setOnEditorActionListener { v, actionId, _ ->            if (actionId == EditorInfo.IME_ACTION_SEARCH) {                if (v.text.toString().isNotEmpty()) {                    searchMovie(v.text.toString())                }            }            false        }        mViewModel.getWeatherReport().observe(viewLifecycleOwner, Observer {            progress_circle.visibility = View.GONE            if (it != null && it.cnt > 0) {                weatherList.addAll(it.list)                mWeatherAdapter.notifyDataSetChanged()                no_data.visibility = View.GONE            } else if (root != null) {                no_data.visibility = View.VISIBLE                Toast.makeText(this.context, "Network Error", Toast.LENGTH_LONG).show()            }        })        return root    }    private fun setUpView(view: View) {        weatherList = mutableListOf()        mSearchView = view.findViewById(R.id.search_sv)        mSearchPlate = mSearchView.findViewById(R.id.search_src_text)        mMovieRV = view.findViewById(R.id.list_item)        mMovieRV.layoutManager = GridLayoutManager(context, 1)        mWeatherAdapter = WeatherAdapter(weatherList)        mMovieRV.adapter = mWeatherAdapter    }    private fun searchMovie(movieName: String) {        progress_circle.visibility = View.VISIBLE        no_data.visibility = View.VISIBLE        weatherList.clear()        mViewModel.getSearchResult(movieName)        hideKeyboard()    }    private fun hideKeyboard() {        val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager        imm.hideSoftInputFromWindow(mSearchPlate.windowToken, 0)    }    override fun onActivityCreated(savedInstanceState: Bundle?) {        super.onActivityCreated(savedInstanceState)    }    companion object {        fun newInstance(): MainFragment {            return MainFragment()        }    }}